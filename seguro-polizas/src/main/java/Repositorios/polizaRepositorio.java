package Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface polizaRepositorio extends JpaRepository<Poliza, String> {
    // Búsqueda por clave (ya incluida por JpaRepository al ser el ID)
    Poliza findByClave(String clave);
    
    // Búsqueda por tipo de póliza
    List<Poliza> findByTipo(Integer tipo);
    
    // Búsqueda por cliente
    List<Poliza> findByClienteCurp(String curp);
    
    // Búsqueda por monto mayor a cierta cantidad
    List<Poliza> findByMontoGreaterThan(float monto);
    
    // Ejemplo de query personalizada para buscar pólizas por descripción que contenga cierto texto
    @Query("SELECT p FROM Poliza p WHERE p.descripcion LIKE %:texto%")
    List<Poliza> buscarPorDescripcion(@Param("texto") String texto);
    
    // Ejemplo de query para encontrar pólizas por rango de monto
    @Query("SELECT p FROM Poliza p WHERE p.monto BETWEEN :montoMinimo AND :montoMaximo")
    List<Poliza> buscarPorRangoMonto(
        @Param("montoMinimo") float montoMinimo, 
        @Param("montoMaximo") float montoMaximo
    );
}

