package com.mds.project.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "stock_instance")
public class StockInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private Double open;

    private Double high;

    private Double low;

    @Column(name = "adj_close")
    private Double adjClose;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    public StockInstance() {

    }

    public StockInstance(Date date, Double open, Double high, Double low, Double adjClose) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.adjClose = adjClose;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getAdjClose() {
        return adjClose;
    }

    public void setAdjClose(Double adjClose) {
        this.adjClose = adjClose;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "StockInstance{" +
                "id=" + id +
                ", date=" + date +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", adjClose=" + adjClose +
                '}';
    }
}
