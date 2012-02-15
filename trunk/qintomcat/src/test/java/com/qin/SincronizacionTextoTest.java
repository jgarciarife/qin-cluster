package com.qin;

import java.util.LinkedList;

import junit.framework.TestCase;

import com.qin.utils.diff_match_patch;
import com.qin.utils.diff_match_patch.Diff;
import com.qin.utils.diff_match_patch.Patch;

public class SincronizacionTextoTest extends TestCase {
	public void testCasoSimple() {
		// agregacion - no se pisa la modificacion con el texto de la segunda
		// persona
		diff_match_patch dmp = new diff_match_patch();

		String textoBase = "El primer texto";
		String modificacionPersona1 = "El otro dia sume un primer texto";
		String modificacionPersona2 = "El primer texto pero un poco modificado";

		LinkedList<Diff> diffs = dmp.diff_main(textoBase, modificacionPersona1);
		LinkedList<Patch> patches = dmp.patch_make(diffs);

		Object[] patch_apply = dmp.patch_apply(patches, modificacionPersona2);
		assertEquals((String) patch_apply[0],
				"El otro dia sume un primer texto pero un poco modificado");
	}

	public void testCasoSimple2() {
		// modificacion - no se pisa la modificacion con el texto de la segunda
		// persona
		diff_match_patch dmp = new diff_match_patch();

		String textoBase = "El primer texto";
		String modificacionPersona1 = "El pRImerisimo texto";
		String modificacionPersona2 = "El primer texto pero un poco modificado";

		LinkedList<Diff> diffs = dmp.diff_main(textoBase, modificacionPersona1);
		LinkedList<Patch> patches = dmp.patch_make(diffs);

		Object[] patch_apply = dmp.patch_apply(patches, modificacionPersona2);
		assertEquals((String) patch_apply[0],
				"El pRImerisimo texto pero un poco modificado");

	}

	public void testCasoSimple3() {
		// borrado - no se pisa la modificacion con el texto de la segunda
		// persona
		diff_match_patch dmp = new diff_match_patch();

		String textoBase = "El primer texto";
		String modificacionPersona1 = "El texto";
		String modificacionPersona2 = "El primer texto pero un poco modificado";

		LinkedList<Diff> diffs = dmp.diff_main(textoBase, modificacionPersona1);
		LinkedList<Patch> patches = dmp.patch_make(diffs);

		Object[] patch_apply = dmp.patch_apply(patches, modificacionPersona2);
		assertEquals((String) patch_apply[0],
				"El texto pero un poco modificado");

	}

	public void testCasoComplicado1() {
		// modificacion sobre modificacion - se pisa la modificacion con el
		// texto de la segunda persona
		diff_match_patch dmp = new diff_match_patch();

		String textoBase = "El primer texto";
		String modificacionPersona1 = "El segundo texto";
		String modificacionPersona2 = "El tercer texto pero un poco modificado";

		LinkedList<Diff> diffs = dmp.diff_main(textoBase, modificacionPersona1);
		LinkedList<Patch> patches = dmp.patch_make(diffs);

		Object[] patch_apply = dmp.patch_apply(patches, modificacionPersona2);
		assertEquals((String) patch_apply[0],
				"El sergundo texto pero un poco modificado");

	}

	public void testCasoComplicado2() {
		// modificacion sobre borrado - se pisa la modificacion con el texto de
		// la segunda persona
		diff_match_patch dmp = new diff_match_patch();

		String textoBase = "El primer texto";
		String modificacionPersona1 = "El segundo texto";
		String modificacionPersona2 = "El texto pero un poco modificado";

		LinkedList<Diff> diffs = dmp.diff_main(textoBase, modificacionPersona1);
		LinkedList<Patch> patches = dmp.patch_make(diffs);

		Object[] patch_apply = dmp.patch_apply(patches, modificacionPersona2);
		System.out.println((String) patch_apply[0]);
		assertEquals((String) patch_apply[0],
				"El gundostexto pero un poco modificado");
		// quedo bastante feo pero es esperable

	}

}
