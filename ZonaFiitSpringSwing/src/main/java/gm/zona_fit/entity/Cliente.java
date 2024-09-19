package gm.zona_fit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data  //crea los getters y setters
//@NoArgsConstructor agrega constructor vacio
//@AllArgsConstructor agrega constructor con todos los atributos
@ToString // agrega metodo to string
@EqualsAndHashCode //agrega metodos equals y hashCode
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer membresia;

    public Cliente(){

    }
    public Cliente(Integer id, String nombre, String apellido, Integer membresia ){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.membresia = membresia;
    }
}
