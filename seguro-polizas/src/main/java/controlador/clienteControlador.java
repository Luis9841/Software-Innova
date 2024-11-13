package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import modelo.Cliente;
import modelo.Poliza;
import Servicios.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class clienteControlador {

    @Autowired
    private ClienteService clienteService;

    // Obtener cliente por CURP
    @GetMapping("/cliente/{curp}")
    public ResponseEntity<Cliente> obtenerClientePorCurp(@PathVariable String curp) {
        try {
            Cliente cliente = clienteService.obtenerPorCurp(curp);
            if (cliente != null) {
                return ResponseEntity.ok(cliente);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            // Excepcion para facilitar la depuracion del codigo
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Obtener todos los clientes
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        try {
            List<Cliente> clientes = clienteService.obtenerTodos();
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Registrar nuevo cliente
    @PostMapping("/cliente")
    public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente) {
        try {
            // Validacion de datos que no esten vacios
            if (cliente.getCurp() == null || cliente.getNombres() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            Cliente nuevoCliente = clienteService.guardar(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Actualizar cliente existente
    @PutMapping("/cliente/{curp}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable String curp, @RequestBody Cliente cliente) {
        try {
            if (!curp.equals(cliente.getCurp())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            Cliente clienteActualizado = clienteService.actualizar(cliente);
            return ResponseEntity.ok(clienteActualizado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Eliminar cliente
    @DeleteMapping("/cliente/{curp}")
    public ResponseEntity<String> eliminarCliente(@PathVariable String curp) {
        try {
            Cliente clienteExistente = clienteService.obtenerPorCurp(curp);
            if (clienteExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
            }
            clienteService.eliminarPorCurp(curp);
            return ResponseEntity.ok("Cliente eliminado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

    // Obtener todas las polizas de un cliente
    @GetMapping("/cliente/{curp}/polizas")
    public ResponseEntity<List<Poliza>> obtenerPolizasDeCliente(@PathVariable String curp) {
        try {
            List<Poliza> polizas = clienteService.obtenerPolizasDeCliente(curp);
            if (polizas == null || polizas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(polizas);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Busqueda de clientes por nombre o apellido
    @GetMapping("/clientes/buscar")
    public ResponseEntity<List<Cliente>> buscarClientes(@RequestParam(required = false) String nombre, @RequestParam(required = false) String apellidos) {
        try {
            List<Cliente> clientes = clienteService.buscarPorNombreOApellidos(nombre, apellidos);
            if (clientes == null || clientes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
