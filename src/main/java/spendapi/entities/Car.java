package spendapi.entities;

import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Table(name = "cars")
@Entity
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;

    @Column
    private String description;

    @Column
    private String color;

    @Column(name = "created_at")
	@CreationTimestamp
	private Timestamp createdAt;

    @Column(name = "updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;

    Car() {}

    Car(String model, String description, String color, Timestamp createdAt) {
        this.model = model;
        this.description = description;
        this.color = color;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }

    public String getDescription() {
        return this.description;
    }

    public String getColor() {
        return this.color;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
