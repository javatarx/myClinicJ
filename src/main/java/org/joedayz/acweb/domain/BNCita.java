package org.joedayz.acweb.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

public class BNCita implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long coCita;
    private BNMedico medico;
    private BNUsuario usuario;
    private BNEspecialidad especialidad;
    private Date fecha;
    private String horario;
    private String comentario;
    private char stCita;

    public BNCita() {
    }

    public BNCita(Long coCita, BNMedico medico, BNUsuario usuario,
            BNEspecialidad especialidad, Date fecha, String horario,
            String comentario) {
        super();
        this.coCita = coCita;
        this.medico = medico;
        this.usuario = usuario;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.horario = horario;
        this.comentario = comentario;
    }

    @Id
    @Column(name = "CO_CITA")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getCoCita() {
        return coCita;
    }

    public void setCoCita(Long coCita) {
        this.coCita = coCita;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Column
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Column(name = "ST_CITA")
    public char getStCita() {
        return stCita;
    }

    public void setStCita(char stCita) {
        this.stCita = stCita;
    }

    @ManyToOne
    @JoinColumn(name = "CO_MEDICO", nullable = false)
    public BNMedico getMedico() {
        return medico;
    }

    public void setMedico(BNMedico medico) {
        this.medico = medico;
    }

    @ManyToOne
    @JoinColumn(name = "CO_USUARIO", nullable = false)
    public BNUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(BNUsuario usuario) {
        this.usuario = usuario;
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
