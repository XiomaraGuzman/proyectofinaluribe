package com.example.viaticosonline.servicios;

import com.example.viaticosonline.entidades.Empleado;
import com.example.viaticosonline.entidades.Viaje;
import com.example.viaticosonline.repositorios.RepositorioViajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ServicioViaje implements ServicioBase <Viaje>{
    @Autowired
    RepositorioViajes repositorioViajes;

    @Override
    public List<Viaje> buscarTodos() throws Exception {
        try {
            List <Viaje> viajes = repositorioViajes.findAll();
            return viajes;

        }catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public Viaje buscarPorId(Integer id) throws Exception {
        try {
          Optional<Viaje> viajeBuscado = repositorioViajes.findById(id);
          return viajeBuscado.get();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Viaje registrar(Viaje entidad) throws Exception {
        try{

            entidad=repositorioViajes.save(entidad);
            return entidad;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Viaje editar(Integer id, Viaje entidad) throws Exception {
        try{
            Optional<Viaje> viajeBuscado = repositorioViajes.findById(id);
            Viaje viaje = viajeBuscado.get();
            viaje = repositorioViajes.save(entidad);
            return viaje;

        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }
}
