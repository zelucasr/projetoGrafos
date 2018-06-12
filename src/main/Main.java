package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import graph.Edge;
import graph.Graph;
import graph.Node;
import util.PathHelper;

public class Main {

	public static void main(String[] args) {
		
		Graph graph = new Graph(4);
		
		graph.addEdge(0, 1, 4, 2);
		graph.addEdge(0, 2, 2, 2);
		graph.addEdge(1, 2, 2, 1);
		graph.addEdge(1, 3, 3, 3);
		graph.addEdge(2, 3, 5, 1);
		
		minCostFlow(graph, 0, 3);
		//ArrayList<PathHelper> paths = bellmanFord(graph, 0);
		//findPath(paths, 0, 5);
		
	}
	
	public static void minCostFlow(Graph graph, Integer from, Integer to){
		int totalCost = 0;
		int totalFlow = 0;
		ArrayList<PathHelper> paths = new ArrayList<PathHelper>();
		boolean hasFlow = true;
		
		while(hasFlow){
		
			paths = bellmanFord(graph, from); //executa bellmanFord
			if(paths.get(to).getCost() != Integer.MAX_VALUE){ //verifica se ainda tem fluxo para nó destino
				int cost = paths.get(to).getCost(); //menor custo para chegar ao nó
				//System.out.println("from " + from + " to " + to + ", cost: "+ cost);
				ArrayList<Integer> completePath = findPath(paths, from, to); //pega o caminho
				if(completePath.size() >= 2){
					Edge firstEdge = graph.getEdge(completePath.get(0), completePath.get(1));
					int lowerFlow = firstEdge.getMaxCapacity() - firstEdge.getActualCapacity();
					for(int i=0, j=1; j < completePath.size(); i++, j++){
						Edge edge = graph.getEdge(completePath.get(i), completePath.get(j)); //pega a aresta da ligação
						if((edge.getMaxCapacity() - edge.getActualCapacity()) < lowerFlow){
							lowerFlow = edge.getMaxCapacity() - edge.getActualCapacity();
							//System.out.println(lowerFlow);
						}
					}
					for(int i=0, j=1; j < completePath.size(); i++, j++){
						Edge edge = graph.getEdge(completePath.get(i), completePath.get(j));
						graph.getEdge(completePath.get(i), completePath.get(j)).setActualCapacity(edge.getActualCapacity() + lowerFlow); //soma no fluxo
						//System.out.println(graph.getEdge(completePath.get(i), completePath.get(j)).getActualCapacity());
						//totalCost = totalCost + (lowerFlow * edge.getCost()); //soma os custos
					}
					//System.out.println("--lowerFlow: "+ lowerFlow + " cost: " + cost+"--");
					totalCost = totalCost + (cost * lowerFlow);
					totalFlow = totalFlow + lowerFlow;
				}
				//System.out.println("totalCost: "+ totalCost);
			} else {
				hasFlow = false;
			}
		
		}
		
		System.out.println("Total flow: " + totalFlow);
		System.out.println("Total cost: " + totalCost);
		
	}
	
	public static ArrayList<PathHelper> bellmanFord(Graph graph, Integer from){
		
		ArrayList<Node> nodes = graph.getNodes(); //Lista de vertices
		
		Integer numNodes = graph.getNumNodes();
		
		ArrayList<PathHelper> paths = new ArrayList<PathHelper>(); //Lista com o custo para chegar a cada nó e de qual nó está vindo
		paths = initPaths(paths, numNodes); //inicia a lista
		int[] minimumCosts = new int[numNodes]; //Lista de custos para o algoritmo de bellmandFord
		Arrays.fill(minimumCosts, Integer.MAX_VALUE); //O vetor inteiro com infinito
		minimumCosts[from] = 0; //Inicial começa com zero
		
		paths.get(from).setCost(0);
		paths.get(from).setSourceNode(from);
		
		for(int i = 0; i < numNodes-1; i++){ //bellmanFord Executa n-1 vezes
			for(int j = 0; j < minimumCosts.length; j++){ //Percorre o vetor de custos
				if(minimumCosts[j] != Integer.MAX_VALUE){ //Verifica se já encontrou aquele nó
					ArrayList<Edge> edges = nodes.get(j).getEdgesAdjacent(); //arestas adjacentes
					int numNodesAdjacents = edges.size(); //número de nós adjacentes
					for(int k = 0; k < numNodesAdjacents; k++){ //Visita os nós adjacentes e verifica o custo
						if(edges.get(k).getActualCapacity() < edges.get(k).getMaxCapacity()){ //Verifica se ainda há capacidade para utilizar a aresta
							int cost = edges.get(k).getCost();
							int target = edges.get(k).getTarget();
							int source = edges.get(k).getSource();
							if(minimumCosts[target] > cost + minimumCosts[source]){
								minimumCosts[target] = cost + minimumCosts[source];
								paths.get(target).setCost(minimumCosts[target]);
								paths.get(target).setSourceNode(source);
							}
						}
					}
				}
			}
		}
		return paths;
		
	}
	
	//resgata o caminho para um determinado nó, após calcular o bellmanFord
	public static ArrayList<Integer> findPath(ArrayList<PathHelper> paths, int source, int target){
		ArrayList<Integer> completePath = new ArrayList<Integer>();
		if(paths.get(target).getCost() != Integer.MAX_VALUE ){ //verifica se é possível chegar até aquele nó
			while(paths.get(target).getSourceNode() != target){
				completePath.add(target);
				target = paths.get(target).getSourceNode();
			}
			completePath.add(source);
			Collections.reverse(completePath);
			//for(Integer p: completePath){ //imprime
				//System.out.println(p);
			//}
			return completePath;
		} else {
			//System.out.println("Não é possível chegar no nó " + target + " a partir do nó " + source);
			return completePath;
		}
		
	}
	
	public static ArrayList<PathHelper> initPaths(ArrayList<PathHelper> paths, int numNodes){
		for(int i = 0; i < numNodes; i++){
			paths.add(new PathHelper(Integer.MAX_VALUE, -1));
		}
		return paths;
	}

}
