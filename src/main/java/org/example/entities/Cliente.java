package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name = "clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @Column(name = "forma_pago", nullable = false, length = 15)
    private String formaPago;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "tbl_clientes_direcciones",
            joinColumns = @JoinColumn(name = "id_cliente"),
            inverseJoinColumns = @JoinColumn(name = "id_direccion"),
            uniqueConstraints = @UniqueConstraint(columnNames={"id_direccion"}))
    private List<Direccion> direcciones;

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Embedded
    private Auditoria audit = new Auditoria();
}
