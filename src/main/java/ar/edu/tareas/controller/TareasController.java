package ar.edu.tareas.controller;

import java.util.List;

import ar.edu.tareas.repos.RepoUsuarios;
import spark.Spark;
import ar.edu.tareas.controller.util.JsonTransformer;
import ar.edu.tareas.domain.Tarea;
import ar.edu.tareas.repos.RepoTareas;

import com.google.gson.Gson;

public class TareasController {

	private JsonTransformer jsonTransformer;
	private Gson gson;

	public TareasController(JsonTransformer jsonTransformer, Gson gson) {
		this.jsonTransformer = jsonTransformer;
		this.gson = gson;
	}

	public void register() {

		Spark.exception(RuntimeException.class, (ex, request, response) -> {
			response.status(400);
			response.body(ex.getMessage());
		});

		Spark.get("/tareas", (request, response) -> {
			response.type("application/json;charset=utf-8");
			return RepoTareas.getInstance().allInstances();
		}, this.jsonTransformer);

		Spark.put("/tareas/:id", (request, response) -> {
			Tarea tarea = this.gson.fromJson(request.body(), Tarea.class);
			String id = request.params("id");
			if (Integer.parseInt(id) != tarea.getId()) {
				throw new RuntimeException("Id en URL distinto del cuerpo");
			}

			RepoTareas.getInstance().update(tarea);
			response.type("application/json;charset=utf-8");
			return "{\"status\": \"OK\"}";
		});

		Spark.get("/usuarios", (request, response) -> {
			response.type("application/json;charset=utf-8");
			return RepoUsuarios.getInstance().allInstances();
		}, this.jsonTransformer);
	}
}
