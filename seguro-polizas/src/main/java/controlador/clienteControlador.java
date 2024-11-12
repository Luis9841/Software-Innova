package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import modelo.Cliente;
import modelo.Poliza;
import Servicios.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api")

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
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Obtener todos los clientes
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        try {
            List<Cliente> clientes = clienteService.obtenerTodos();
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Registrar nuevo cliente
    @PostMapping("/cliente")
    public ResponseEntity<Cliente> registrarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente nuevoCliente = clienteService.guardar(cliente); // Guardar NO genera un cliente...
            return ResponseEntity.ok(nuevoCliente);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Actualizar cliente existente
    @PutMapping("/cliente/{curp}")
    public ResponseEntity<Cliente> actualizarCliente(
            @PathVariable String curp,
            @RequestBody Cliente cliente) {
        try {
            if (!curp.equals(cliente.getCurp())) {
                return ResponseEntity.badRequest().build();
            }
            Cliente clienteActualizado = clienteService.actualizar(cliente); // una ACTUALIZACIÓN NO genera un nuevo cliente...
            return ResponseEntity.ok(clienteActualizado);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Eliminar cliente
    @DeleteMapping("/cliente/{curp}")
    public ResponseEntity<String> eliminarCliente(@PathVariable String curp) {
        try {
            clienteService.eliminarPorCurp(curp);
            return ResponseEntity.ok("Cliente eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Obtener todas las pólizas de un cliente
    @GetMapping("/cliente/{curp}/polizas")
    public ResponseEntity<List<Poliza>> obtenerPolizasDeCliente(@PathVariable String curp) {
        try {
            List<Poliza> polizas = clienteService.obtenerPolizasDeCliente(curp);
            return ResponseEntity.ok(polizas);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Búsqueda de clientes por nombre o apellido
    @GetMapping("/clientes/buscar")
    public ResponseEntity<List<Cliente>> buscarClientes(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellidos) {
        try {
            List<Cliente> clientes = clienteService.buscarPorNombreOApellidos(nombre, apellidos);
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
sdfsdvhsivhsdvdssvhkdsvhdsklvsdl
sdclsdnsdlvdslvsdkl
svosñvosdvdss
sçsvsñdjvdsvlss
vds
v
sdv
dsv
v
ds


