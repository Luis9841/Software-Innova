package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import modelo.Poliza;
import Servicios.polizaService;

import java.util.List;

@RestController
@RequestMapping("/api/polizas")
public class polizaControlador {

    @Autowired
    private polizaService polizaServicio;

    // Endpoint para obtener pólizas por CURP del cliente
    @GetMapping("/cliente/{curp}")
    public List<Poliza> obtenerPolizasPorCurp(@PathVariable String curp) {
        return polizaServicio.obtenerPorCurpCliente(curp);
    }

    // Endpoint para obtener pólizas por tipo
    @GetMapping("/tipo/{tipo}")
    public List<Poliza> obtenerPolizasPorTipo(@PathVariable String tipo) {
        return polizaServicio.obtenerPorTipo(tipo);
    }

    // Endpoint para obtener pólizas con monto asegurado mínimo
    @GetMapping("/montoMinimo/{montoAsegurado}")
    public List<Poliza> obtenerPolizasPorMontoMinimo(@PathVariable double montoAsegurado) {
        return polizaServicio.obtenerPorMontoAseguradoMinimo(montoAsegurado);
    }

    // Endpoint para obtener pólizas por nombre del cliente
    @GetMapping("/cliente/nombre/{nombres}")
    public List<Poliza> obtenerPolizasPorNombreCliente(@PathVariable String nombres) {
        return polizaServicio.obtenerPorNombreCliente(nombres);
    }

    // Endpoint para obtener pólizas por tipo y monto asegurado mínimo
    @GetMapping("/tipo/{tipo}/montoMinimo/{montoAsegurado}")
    public List<Poliza> obtenerPolizasPorTipoYMontoMinimo(
            @PathVariable String tipo, @PathVariable double montoAsegurado) {
        return polizaServicio.obtenerPorTipoYMontoMinimo(tipo, montoAsegurado);
    }

    // Endpoint para guardar una nueva póliza
    @PostMapping
    public Poliza guardarPoliza(@RequestBody Poliza poliza) {
        return polizaServicio.guardar(poliza);
    }

    // Endpoint para obtener todas las pólizas
    @GetMapping
    public List<Poliza> obtenerTodasLasPolizas() {
        return polizaServicio.obtenerTodas();
    }

    // Endpoint para eliminar una póliza por clave
    @DeleteMapping("/{clave}")
    public String eliminarPoliza(@PathVariable String clave) {
        boolean eliminado = polizaServicio.eliminarPorClave(clave);
        return eliminado ? "Póliza eliminada correctamente" : "Póliza no encontrada";
    }
}
