package Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import modelo.Poliza;

import java.util.List;

@Repository
public interface polizaRepositorio extends JpaRepository<Poliza, String> 
{

    // Método para encontrar pólizas por CURP del cliente
    List<Poliza> findByCurpCliente(String curp);

    // Método para encontrar pólizas por tipo
    List<Poliza> findByTipo(String tipo);

    // Método para encontrar pólizas con monto asegurado mayor o igual al
    // especificado
    List<Poliza> findByMontoAseguradoGreaterThanEqual(double montoAsegurado);

    // Método para encontrar pólizas por nombre del cliente
    List<Poliza> findByNombreClienteContainingIgnoreCase(String nombres);

    // Método para encontrar pólizas por tipo y monto asegurado mínimo
    List<Poliza> findByTipoAndMontoAseguradoGreaterThanEqual(String tipo, double montoAsegurado);
}
