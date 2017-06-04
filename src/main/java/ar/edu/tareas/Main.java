package ar.edu.tareas;

import spark.Spark;
import ar.edu.tareas.controller.TareasController;
import ar.edu.tareas.controller.util.JsonTransformer;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		Gson gson = new Gson();
		JsonTransformer jsonTransformer = new JsonTransformer(gson);

		Spark.port(9000);
		Spark.staticFileLocation("/webapp/dist");

		new TareasController(jsonTransformer, gson).register();
	}
}
