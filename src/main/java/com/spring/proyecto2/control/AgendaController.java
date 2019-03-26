package com.spring.proyecto2.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.proyecto2.model.Contacto;
import com.spring.proyecto2.model.Persona;
import com.spring.proyecto2.model.Provincia;
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
	 * Método para llevar a cabo la comunicación y devolver el listado de contactos
	 * de la agenda
	 * 
	 * @return model Direccional al JSP listadoCont con la lista de contactos
	 */
	@RequestMapping("/")
	public ModelAndView listContactos() {
		List<Persona> listPers = agendaService.list();
		ModelAndView model = new ModelAndView("listadoCont");
		model.addObject("listaContactos", listPers);
		return model;
	}

	/**
	 * Método para mostrar la ficha de un contacto
	 * 
	 * @param request Recibe el parámetro de entrada id de la persona de la que se
	 *	mostrará la ficha
	 * @return Direcciona al JSP de
	 */
	@GetMapping("/ficha")
	public ModelAndView fichaContacto(HttpServletRequest request) {
		int idContacto = Integer.parseInt(request.getParameter("id"));
		Persona persona = agendaService.buscarId(idContacto);
		ModelAndView model = new ModelAndView("ficha");
		model.addObject("persona", persona);
		return model;
	}

	/**
	 * Método para volver a la página de inicio desde la ficha del contacto
	 * 
	 * @return Redirecciona a la página principal
	 */
	@GetMapping("/vuelta")
	public ModelAndView vueltaLista() {
		return new ModelAndView("redirect:/#listadox");
	}

	/**
	 * Metodo para editar una persona, autorrellenamos los campos del formulario utilizado para añadir persona para poder modificar los campos adecuados.
	 * 
	 * @param request: recoge el id de la persona que se quiere editar.
	 * @return model: devuelve un model el cual lleva un objeto de tipo persona
	 */
	@GetMapping("/editar")
	public ModelAndView editarPersona(HttpServletRequest request) {
		int idContacto = Integer.parseInt(request.getParameter("id"));
		Persona persona = agendaService.buscarId(idContacto);
		Contacto contacto = new Contacto(persona, persona.getDireccions().get(0), persona.getTelefonos().get(0),
				persona.getDireccions().get(0).getProvincia());
		ModelAndView model = new ModelAndView("formulario");
		List<Provincia> listaProv = agendaService.listProv();
		model.addObject("listaProv", listaProv);
		model.addObject("prove", contacto.getProv());
		model.addObject("contacto", contacto);
		return model;
	}

	/**
	 * Método para borrar un contactor
	 * 
	 * @param request Recibe el parámetro de entrada id de la persona que se
	 * eliminará
	 * @return Redirecciona al JSP listadoCont con el contacto eliminado
	 */
	@GetMapping("/delete")
	public ModelAndView borrarContacto(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/#listadox");
		int idContacto = Integer.parseInt(request.getParameter("id"));
		agendaService.delete(idContacto);
		return mv;
	}

	/**
	 * Método para añadir un nuevo contacto a la agenda
	 * 
	 * @return Devuelve el modelo de la persona rellenada en el JSP formulario
	 */
	@GetMapping("/new")
	public ModelAndView addContacto() {
		ModelAndView model = new ModelAndView("formulario");
		List<Provincia> listaProv = agendaService.listProv();
		model.addObject("listaProv", listaProv);
		model.addObject("contacto", new Contacto());
		return model;
	}

	/**
	 * Método para guardar el contacto creado en el método anterior añadir o
	 * modificar Contacto
	 * 
	 * @param contacto Recibe un Contacto desde el JSP formulario
	 * @return Redirecciona a la página principal (JSP listadoCont) con el contacto
	 *         guardado
	 */
	@PostMapping("/save")
	public ModelAndView saveContacto(@ModelAttribute Contacto contacto) {
		if (contacto.getPers().getIdpersona() != 0) {
			agendaService.edit(contacto.getPers(), contacto.getDir(), contacto.getTel(), contacto.getProv());
		} else {
			agendaService.add(contacto.getPers(), contacto.getDir(), contacto.getTel(), contacto.getProv());
		}

		return new ModelAndView("redirect:/#listadox");
	}

	/**
	 * Metodo para editar una persona, la cual enviamos al formulario de añadir y
	 * modificamos ahí sus atributos.
	 * 
	 * @param request: recoge el id de la persona que quieres editar.
	 * @return model: devuelve un model el cual lleva un objeto de tipo persona
	 */
	@GetMapping("/edit")
	public ModelAndView editContacto(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("formulario");
		model.addObject("persona", agendaService.buscarId(Integer.parseInt(request.getParameter("id"))));
		return model;
	}

	/**
	 * Método para far formato a las fechas.
	 * 
	 * @param binder  Un método init binder inicializa WebDataBinder y registra manejadores específicos
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
