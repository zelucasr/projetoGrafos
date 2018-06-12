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
		
		Graph graph = new Graph(7);
		
		graph.addEdge(0, 1, 3);
		graph.addEdge(0, 2, 2);
		
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 4, 3);
		graph.addEdge(1, 6, 3);
		
		graph.addEdge(2, 3, 2);
		graph.addEdge(2, 4, 2);
		graph.addEdge(2, 5, 3);
		
		graph.addEdge(3, 1, 2);
		graph.addEdge(3, 5, 2);
		graph.addEdge(3, 6, 2);
		
		graph.addEdge(6, 4, 3);
		
		ArrayList<PathHelper> paths = bellmanFord(graph, 0);
		findPath(paths, 0, 5);
		
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
		
		/*int x=0;
		for(int cost: minimumCosts){
			System.out.println(x + " " + cost);
			x++;
		}*/
		
		return paths;
		
	}
	
	//resgata o caminho para um determinado nó, após calcular o bellmanFord
	public static void findPath(ArrayList<PathHelper> paths, int source, int target){
		ArrayList<Integer> completePath = new ArrayList<Integer>();
		while(paths.get(target).getSourceNode() != target){
			completePath.add(target);
			target = paths.get(target).getSourceNode();
		}
		completePath.add(source);
		Collections.reverse(completePath);
		for(Integer p: completePath){
			System.out.println(p);
		}
	}
	
	public static ArrayList<PathHelper> initPaths(ArrayList<PathHelper> paths, int numNodes){
		
		for(int i = 0; i < numNodes; i++){
			paths.add(new PathHelper(Integer.MAX_VALUE, -1));
		}
		
		return paths;
	}

}
