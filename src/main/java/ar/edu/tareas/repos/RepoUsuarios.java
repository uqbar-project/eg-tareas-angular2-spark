package ar.edu.tareas.repos;

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

import ar.edu.tareas.domain.Usuario;

public class RepoUsuarios extends CollectionBasedHome<Usuario> {

	/* Singleton */
	private static RepoUsuarios repoUsuarios;

	public static RepoUsuarios getInstance() {
		if (repoUsuarios == null) {
			repoUsuarios = new RepoUsuarios();
		}
		return repoUsuarios;
	}

	private RepoUsuarios() {
		this.create(new Usuario("Fernando Dodino"));
		this.create(new Usuario("Rodrigo Grisolia"));
		this.create(new Usuario("Javier Casaubon"));
		this.create(new Usuario("Marcos Pavelek"));
	}

	@Override
	public Usuario createExample() {
		return new Usuario();
	}

	@Override
	public Class<Usuario> getEntityType() {
		return Usuario.class;
	}

	@Override
	protected Predicate<Usuario> getCriterio(Usuario example) {
		return new Predicate<Usuario>() {
			@Override
			public boolean evaluate(Usuario usuario) {
				return usuario.getNombre().contains(example.getNombre());
			}
		};
	}

}
