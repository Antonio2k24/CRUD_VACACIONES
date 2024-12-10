package com.idat.personalplanta.service;

import com.idat.personalplanta.model.Empleado;
import com.idat.personalplanta.model.Usuario;
import com.idat.personalplanta.repository.EmpleadoRepository;
import com.idat.personalplanta.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService{

    private final EmpleadoRepository empleadoRepository;
    private final UsuarioRepository UsuarioRepository;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        if (empleado.getUsuario().getId() != null) {
            Usuario obUsu = UsuarioRepository.findById(empleado.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado para el id: " + empleado.getUsuario().getId()));
            empleado.getUsuario().setContrasena(obUsu.getContrasena());
        }
        UsuarioRepository.save(empleado.getUsuario());
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado obtenerEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado para el id: " + id));
    }

    @Override
    public void eliminarEmpleado(Integer id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Empleado no encontrado para el id: " + id);
        }

    }

    @Override
    public List<Empleado> listarEmpleadoPorCapacitacionId(Integer idCapacitacion) {
        return empleadoRepository.findAllByCapacitacionId(idCapacitacion);
    }
}
