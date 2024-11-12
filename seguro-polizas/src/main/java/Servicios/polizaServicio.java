package Servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import modelo.Poliza;
import java.util.List;
import java.util.Optional;

import Repositorios.polizaRepositorio;

@Service
public class polizaServicio {

    @Autowired
    private polizaRepositorio polizaRepositorio;

    // Método para obtener pólizas por CURP del cliente
    public List<Poliza> obtenerPorCurpCliente(String curp) {
        return polizaRepositorio.findByCurpCliente(curp);
    }

    // Método para obtener pólizas por tipo
    public List<Poliza> obtenerPorTipo(String tipo) {
        return polizaRepositorio.findByTipo(tipo);
    }

    // Método para obtener pólizas con monto asegurado mínimo
    public List<Poliza> obtenerPorMontoAseguradoMinimo(double montoAsegurado) {
        return polizaRepositorio.findByMontoAseguradoGreaterThanEqual(montoAsegurado);
    }

    // Método para obtener pólizas por nombre del cliente
    public List<Poliza> obtenerPorNombreCliente(String nombres) {
        return polizaRepositorio.findByNombreClienteContainingIgnoreCase(nombres);
    }

    // Método para obtener pólizas por tipo y monto asegurado mínimo
    public List<Poliza> obtenerPorTipoYMontoMinimo(String tipo, double montoAsegurado) {
        return polizaRepositorio.findByTipoAndMontoAseguradoGreaterThanEqual(tipo, montoAsegurado);
    }

    // Método para guardar una nueva póliza
    public Poliza guardar(Poliza poliza) {
        return polizaRepositorio.save(poliza);
    }

    // Método para obtener todas las pólizas
    public List<Poliza> obtenerTodas() {
        return polizaRepositorio.findAll();
    }

    // Método para eliminar una póliza por clave
    public boolean eliminarPorClave(String clave) {
        Optional<Poliza> poliza = polizaRepositorio.findById(clave);
        if (poliza.isPresent()) {
            polizaRepositorio.deleteById(clave);
            return true;
        }
        return false;
    }
}
