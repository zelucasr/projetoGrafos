package main;

import java.util.ArrayList;

import graph.Graph;
import modelProblem.Airplane;
import modelProblem.FlightPlan;
import util.RandomUtil;

public class Controller {

	private static ArrayList<Airplane> airplanes; // Possíveis aviões durante a execução
	private static Graph graph; // Grafo
	private static ArrayList<Airplane> priorityAirplanes; // Lista de prioridade dos aviões
	private static ArrayList<FlightPlan> flightPlans; // Lista de planos de vôo
	private static RandomUtil randomUtil; // Para utilizar números aleatórios

	public static void main(String[] args) {
		
		initVariables();
		createAirplaneTypes();
		
		
	}

	private static void initVariables() {
		
		airplanes = new ArrayList<Airplane>();
		graph = new Graph();
		priorityAirplanes = new ArrayList<Airplane>();
		flightPlans = new ArrayList<FlightPlan>();
		randomUtil = new RandomUtil();
		
	}

	private static void createAirplaneTypes() {
		
		airplanes.add(new Airplane(900, "Tupolev Tu204-100"));
		airplanes.add(new Airplane(800, "B737-800"));
		airplanes.add(new Airplane(350, "Adam A500"));
		airplanes.add(new Airplane(500, "DC-9 Hughes"));
		airplanes.add(new Airplane(730, "Embraer 175"));
		airplanes.add(new Airplane(670, "Caravelle French"));
		
	}
	
	private static Airplane generateNewAirplane(){
		
		Integer random = randomUtil.generateInteger(airplanes.size());
		Airplane randomAirplane = airplanes.get(random);
		Airplane newAirplane = new Airplane(randomAirplane.getSize(), randomAirplane.getModel());
		
		return newAirplane;
		
	}

}
