package org.joedayz.acweb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ESPECIALIDAD")
public class BNEspecialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long coEspecialidad;
    private String deEspecialidad;
    private char stEspecialidad;

    public BNEspecialidad() {
    }

    public BNEspecialidad(Long coEspecialidad, String deEspecialidad) {
        super();
        this.coEspecialidad = coEspecialidad;
        this.deEspecialidad = deEspecialidad;
    }

    @Id
    @Column(name = "CO_ESPECIALIDAD")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getCoEspecialidad() {
        return coEspecialidad;
    }

    public void setCoEspecialidad(Long coEspecialidad) {
        this.coEspecialidad = coEspecialidad;
    }

    @Column(name = "DE_ESPECIALIDAD")
    public String getDeEspecialidad() {
        return deEspecialidad;
    }

    public void setDeEspecialidad(String deEspecialidad) {
        this.deEspecialidad = deEspecialidad;
    }

    @Column(name = "ST_ESPECIALIDAD")
    public char getStEspecialidad() {
        return stEspecialidad;
    }

    public void setStEspecialidad(char stEspecialidad) {
        this.stEspecialidad = stEspecialidad;
    }

}
