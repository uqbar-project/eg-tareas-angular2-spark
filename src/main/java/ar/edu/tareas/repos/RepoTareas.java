package ar.edu.tareas.repos;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

import ar.edu.tareas.domain.Tarea;
import ar.edu.tareas.domain.Usuario;

public class RepoTareas extends CollectionBasedHome<Tarea> {

	private RepoUsuarios repoUsuario;

	/* Singleton */
	private static RepoTareas repoTareas;

	public static RepoTareas getInstance() {
		if (RepoTareas.repoTareas == null) {
			RepoTareas.repoTareas = new RepoTareas();
		}
		return RepoTareas.repoTareas;
	}

	@SuppressWarnings("deprecation")
	private RepoTareas() {
		this.repoUsuario = RepoUsuarios.getInstance();
		this.crearTarea("Desarrollar componente de envio de mails", "Marcos Pavelek", new Date(), "Iteración 1", 0);
		this.crearTarea("Implementar single sign on desde la extranet", null, new Date(9, 9, 114), "Iteración 1", 76);
		this.crearTarea("Cancelar pedidos que esten pendientes desde hace 2 meses", "Rodrigo Grisolia", new Date(3, 2, 115), "Iteración 1", 22);
		this.crearTarea("Mostrar info del pedido cuando esta finalizado", null, new Date(8, 10, 114), "Iteración 2", 90);
	}

	public Tarea crearTarea(String unaDescripcion, String responsable, Date date, String unaIteracion, int cumplimiento) {
		Tarea tarea = new Tarea();

		if (responsable != null) {
			tarea.setAsignatario(this.repoUsuario.searchByExample(new Usuario(responsable)).get(0));
		}
		tarea.setDescripcion(unaDescripcion);
		if (date == null) {
			tarea.setFecha(new Date());
		} else {
			tarea.setFecha(date);
		}
		tarea.setIteracion(unaIteracion);
		tarea.setPorcentajeCumplimiento(cumplimiento);

		this.create(tarea);
		return tarea;
	}

	@Override
	protected Predicate<Tarea> getCriterio(Tarea example) {
		return new Predicate<Tarea>() {
			@Override
			public boolean evaluate(Tarea tarea) {
				return example.getDescripcion().contains(tarea.getDescripcion());
			}
		};
	}

	@Override
	public Tarea createExample() {
		return new Tarea();
	}

	@Override
	public Class<Tarea> getEntityType() {
		return Tarea.class;
	}

	public List<Tarea> tareasPendientes() {
		return this.allInstances().stream().filter(Tarea::estaPendiente).collect(Collectors.toList());
	}
}
