package controlador;


import modelo.Beneficiario;
import modelo.Poliza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Servicios.BeneficiarioService;


@RestController
@RequestMapping("/api/beneficiarios")
public class beneficiarioControlador 
{
    @Autowired
    private BeneficiarioService beneficiarioService;

    @GetMapping("/beneficiario/{curp}")
    public ResponseEntity<Beneficiario> obtenerBeneficiarioPorCurp(@PathVariable String curp)
    {
        try
        {
            Beneficiario beneficiario = beneficiarioService.obtenerPorCurp(curp);
            if(beneficiario != null)
            {
                return ResponseEntity.ok(beneficiario);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);//inidica que el recurso no fue encotrado
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);//indica que ocurrio un error
        }
    }

    // Obtener todos los clientes
    @GetMapping("/clientes")
    public ResponseEntity<List<Beneficiario>> obtenerTodosLosClientes() {
        try {
            List<Beneficiario> beneficiarios = beneficiarioService.obtenerTodos();
            return ResponseEntity.ok(beneficiarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();//se indica que ocurrio un error
        }
    }

    // Registrar nuevo cliente
    @PostMapping("/cliente")
    public ResponseEntity<Beneficiario> registrarCliente(@RequestBody Beneficiario beneficiario) {
        try 
        {
            //validacion de entrada
            if (beneficiario.getNombres()== null || beneficiario.getId()==null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            Beneficiario nuevoBeneficiario = beneficiarioService.guardar(beneficiario); // Guardar NO genera un cliente...
            return ResponseEntity.ok(nuevoBeneficiario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);// se indica que ocurrio un error interno
        }
    }

    // Actualizar cliente existente
    @PutMapping("/beneficiario/{curp}")
    public ResponseEntity<Beneficiario> actualizarBeneficiario(
            @PathVariable String curp,
            @RequestBody Beneficiario beneficiario) {
        try 
        {          
            Beneficiario beneficiarioActualizado = beneficiarioService.actualizar(beneficiario); // una ACTUALIZACIÓN NO genera un nuevo cliente...
            return ResponseEntity.ok(beneficiarioActualizado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Eliminar cliente
    @DeleteMapping("/beneficiario/{curp}")
    public ResponseEntity<String> eliminarBeneficiario(@PathVariable String curp) {
        try {
            beneficiarioService.eliminarPorCurp(curp);
            return ResponseEntity.ok("Beneficiario eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Obtener todas las pólizas de un cliente
    @GetMapping("/cliente/{curp}/polizas")
    public ResponseEntity<List<Poliza>> obtenerPolizasDeCliente(@PathVariable String curp) {
        try {
            List<Poliza> polizas = beneficiarioService.obtenerPolizaDeBeneficiario(curp);
            return ResponseEntity.ok(polizas);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Búsqueda de clientes por nombre o apellido
    @GetMapping("/beneficiario/buscar")
    public ResponseEntity<List<Beneficiario>> buscarBeneficiarios(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellidos) 
    {
        try {
            List<Beneficiario> beneficiarios = beneficiarioService.buscarPorNombre(nombre, apellidos);
            return ResponseEntity.ok(beneficiarios);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
