import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PolizaController {

    @Autowired
    private PolizaService polizaService;
    

    // Endpoints para Poliza
    @GetMapping("/poliza/{clave}")
    public Poliza obtenerPolizaPorClave(@PathVariable String clave) {
        return polizaService.obtenerPorClave(clave);
    }

    @GetMapping("/polizas")
    public List<Poliza> obtenerTodasLasPolizas() {
        return polizaService.obtenerTodas();
    }

    @PostMapping("/poliza")
    public Poliza registrarPoliza(@RequestBody Poliza poliza) {
        return polizaService.guardar(poliza);
    }

    @DeleteMapping("/poliza/{clave}")
    public String borrarPoliza(@PathVariable String clave) {
        polizaService.eliminarPorClave(clave);
        return "Póliza eliminada";
    }
    
}
