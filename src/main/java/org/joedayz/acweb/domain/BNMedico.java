package org.joedayz.acweb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MEDICO")
public class BNMedico implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long coMedico;
    private String deMedico;
    private char stMedico;
    private BNEspecialidad especialidad;

    public BNMedico() {
    }

    public BNMedico(Long coMedico, String deMedico, BNEspecialidad especialidad) {
        super();
        this.coMedico = coMedico;
        this.deMedico = deMedico;
        this.especialidad = especialidad;
    }

    @Id
    @Column(name = "CO_MEDICO")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getCoMedico() {
        return coMedico;
    }

    public void setCoMedico(Long coMedico) {
        this.coMedico = coMedico;
    }

    @Column(name = "DE_MEDICO")
    public String getDeMedico() {
        return deMedico;
    }

    public void setDeMedico(String deMedico) {
        this.deMedico = deMedico;
    }

    @Column(name = "ST_MEDICO")
    public char getStMedico() {
        return stMedico;
    }

    public void setStMedico(char stMedico) {
        this.stMedico = stMedico;
    }

    @ManyToOne
    @JoinColumn(name = "CO_ESPECIALIDAD", nullable = false)
    public BNEspecialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(BNEspecialidad especialidad) {
        this.especialidad = especialidad;
    }

}
