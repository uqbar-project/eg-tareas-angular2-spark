package ar.edu.tareas.domain;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTarea {

	private Tarea tareaOk;
	private Tarea tareaPendiente;

	@Before
	public void init() {
		this.tareaOk = new Tarea("desarrollar test", new Date());
		this.tareaOk.setPorcentajeCumplimiento(100);
		this.tareaPendiente = new Tarea("ser feliz", new Date());
		this.tareaPendiente.setPorcentajeCumplimiento(20);
	}

	@Test
	public void testTareaCumplida() {
		Assert.assertFalse(this.tareaOk.estaPendiente());
		Assert.assertTrue(this.tareaOk.estaCumplida());
	}

	@Test
	public void testTareaNoCumplida() {
		Assert.assertTrue(this.tareaPendiente.estaPendiente());
		Assert.assertFalse(this.tareaPendiente.estaCumplida());
	}
}
