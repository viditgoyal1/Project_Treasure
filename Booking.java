package com.git.MovieMania.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vidit
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByMovie", query = "SELECT b FROM Booking b WHERE b.movie = :movie")
    , @NamedQuery(name = "Booking.findByCinema", query = "SELECT b FROM Booking b WHERE b.cinema = :cinema")
    , @NamedQuery(name = "Booking.findByTiming", query = "SELECT b FROM Booking b WHERE b.timing = :timing")
    , @NamedQuery(name = "Booking.findByTicket", query = "SELECT b FROM Booking b WHERE b.ticket = :ticket")
    , @NamedQuery(name = "Booking.findById1", query = "SELECT b FROM Booking b WHERE b.id1 = :id1")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "movie")
    private String movie;
    @Basic(optional = false)
    @Column(name = "cinema")
    private String cinema;
    @Basic(optional = false)
    @Column(name = "timing")
    private String timing;
    @Basic(optional = false)
    @Column(name = "ticket")
    private int ticket;
    
    private int id1;
    @Basic(optional = false)
    @Column(name = "cust_name")
    private String cust_name;

    public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public Booking() {
    }

    public Booking(int id1) {
        this.id1 = id1;
    }

    public Booking(int id1, String movie, String cinema, String timing, int ticket) {
        this.id1 = id1;
        this.movie = movie;
        this.cinema = cinema;
        this.timing = timing;
        this.ticket = ticket;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
    
    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }
    
    public int getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
       // hash += (id1 != null ? id1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
		/*
		 * if ((this.id1 == null && other.id1 != null) || (this.id1 != null &&
		 * !this.id1.equals(other.id1))) { return false; }
		 */
        return true;
    }

    @Override
    public String toString() {
        return "beans.Booking[ id1=" + id1 + " ]";
    }

    public void getDetails() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

