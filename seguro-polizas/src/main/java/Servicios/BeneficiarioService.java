package Servicios;

import java.util.List;

import Repositorios.beneficiarioRepositorio;
import modelo.Beneficiario;
import modelo.Poliza;

public class BeneficiarioService implements beneficiarioRepositorio
{

    @Override
    public Beneficiario obtenerPorCurp(String curp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPorCurp'");
    }

    @Override
    public List<Beneficiario> obtenerTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodos'");
    }

    @Override
    public Beneficiario guardar(Beneficiario guardar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public Beneficiario actualizar(Beneficiario beneficiario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminarPorCurp(String curp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPorCurp'");
    }

    @Override
    public List<Poliza> obtenerPolizaDeBeneficiario(String curp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPolizaDeBeneficiario'");
    }

    @Override
    public List<Beneficiario> buscarPorNombre(String nombre, String Apellidos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorNombre'");
    }
}
