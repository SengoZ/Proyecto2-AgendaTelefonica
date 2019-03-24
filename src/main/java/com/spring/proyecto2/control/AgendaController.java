package com.spring.proyecto2.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.proyecto2.model.Persona;
import com.spring.proyecto2.services.AgendaService;

/**
 * 
 * @author Amador Cáceres, Cesar Marcos, Andrés Gomez y Sheila García
 * @version 1.0
 * 
 * Controlador de la agenda usando ModelAndView (Controller)
 *
 */
@Controller
public class AgendaController {
	
	@Autowired
	private AgendaService agendaService;
	
	/**
	 * Método para llevar a cabo la comunicación y devolver el listado de contactos de la agenda
	 * @return model Direccional al JSP listadoCont con la lista de contactos
	 */
	@RequestMapping("/")
	public ModelAndView listContactos() {
		List<Persona> listPers = agendaService.list();
		ModelAndView model = new ModelAndView("listadoCont");
		for(Persona i:listPers) {
			System.out.println(i.getNombre());
		}
		model.addObject("listaContactos", listPers);
		return model;
	}
	
	/**
	 * Método para mostrar la ficha de un contacto
	 * @param request Recibe el parámetro de entrada id de la persona de la que se mostrará la ficha
	 * @return Direcciona al JSP de 
	 */
	@GetMapping("/ficha")
	public ModelAndView fichaContacto(HttpServletRequest request) {
		int idContacto = Integer.parseInt(request.getParameter("id"));
		System.out.println("La id seleccionada es "+idContacto);
		Persona persona = agendaService.buscarId(idContacto);
		System.out.println("------ se supone que buscó la ficha");
		ModelAndView model = new ModelAndView("ficha");
		model.addObject("persona", persona);
		return model;
	}
	
	/**
	 * Método para volver a la página de inicio desde la ficha del contacto
	 * @return Redirecciona a la página principal
	 */
	@GetMapping("/vuelta")
	public ModelAndView vueltaLista() {
		return new ModelAndView("redirect:/");
	}
	
	/**
	 * Metodo para editar una persona, la cual enviamos al formulario de añadir y modificamos ahí sus atributos.
	 * @param request: recoge el id de la persona que quieres editar.
	 * @return model: devuelve un model el cual lleva un objeto de tipo persona
	 */
	@GetMapping("/editar")
	public ModelAndView editarPersona(HttpServletRequest request) {
		int idContacto = Integer.parseInt(request.getParameter("id"));
		Persona contacto = agendaService.buscarId(idContacto);
		ModelAndView model = new ModelAndView("formulario");
		model.addObject("persona", contacto);
		return model;
	}
	
	/**
	 * Método para borrar un contactor
	 * @param request Recibe el parámetro de entrada id de la persona que se eliminará
	 * @return Redirecciona al JSP listadoCont con el contacto eliminado
	 */
	@GetMapping("/delete")
	public ModelAndView borrarContacto(HttpServletRequest request, RedirectAttributes redirAtt) {
		ModelAndView mv = new ModelAndView("redirect:/#myModal");
		int idContacto = Integer.parseInt(request.getParameter("id"));
		String out = agendaService.buscarId(idContacto).getNombre()+" "+agendaService.buscarId(idContacto).getApellido1()+" ha sido eliminado de sus contactos!!";
		redirAtt.addFlashAttribute("message", out);
		agendaService.delete(idContacto);
	    return mv;
	}
	
	/**
	 * Método para añadir un nuevo contacto a la agenda
	 * @return Devuelve el modelo de la persona rellenada en el JSP formulario
	 */
	@GetMapping("/new")
	public ModelAndView añadirContacto() {
		ModelAndView model = new ModelAndView("formulario");
		model.addObject("persona", new Persona());
		return model;
	}
	
	/**
	 * Método para guardar el contacto creado en el método anterior añadirContacto
	 * @param persona Recibe una persona desde el JSP formulario
	 * @return Redirecciona a la página principal (JSP listadoCont) con el contacto guardado
	 */
	@PostMapping("/save")
	public ModelAndView saveContacto(@ModelAttribute Persona persona) {
		agendaService.add(persona);
		return new ModelAndView("redirect:/");
	}
	
	
	/**
	 * Metodo para editar una persona, la cual enviamos al formulario de añadir y modificamos ahí sus atributos.
	 * @param request: recoge el id de la persona que quieres editar.
	 * @return model: devuelve un model el cual lleva un objeto de tipo persona
	 */
	@GetMapping("/edit")
	public ModelAndView editContacto(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("formulario");
		model.addObject("persona", agendaService.buscarId(Integer.parseInt(request.getParameter("id"))));
		return model;
	}
	
	
	
	
	

}
