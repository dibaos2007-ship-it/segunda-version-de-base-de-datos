package dao;

import modelo.Planeta;
import java.util.List;

public interface PlanetaDAO {

    Planeta consultarPorId(int id);//ak es para la id


    List<Planeta> consultarTodos();//ak es para que busque todos los planetas


    boolean agregar(Planeta planeta);//ak es para mete un planeta


    List<Planeta> filtrarPorGalaxia(String galaxia);//ak que me filtre un del las galaxias
    List<Planeta> filtrarPorPosibleVida(boolean tieneVida);//ak qie me filtre los que podiran llegar a contener vida
}