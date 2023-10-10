package br.ufscar.dc.dsw.locadora.infrastructure.config.db.schema;

import br.ufscar.dc.dsw.locadora.entity.locacao.model.Locacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

//@ValidLocacao(message = "{ValidLocacao.locacao}")
@Entity
@Table(name = "Locacao",
    uniqueConstraints = @UniqueConstraint(columnNames = {"hour", "date", "client_id"})
)
public class LocacaoSchema extends AbstractEntitySchema<Long> {
  @NotNull
  @Column(nullable = false, columnDefinition = "Time", name = "hour")
  private LocalTime hour;

  @NotNull
  @Column(nullable = false, columnDefinition = "Date", name = "date")
  private LocalDate date;

  @NotNull(message = "{NotNull.locacao.locadora}")
  @ManyToOne
  @JoinColumn(name = "rentalCompany_id")
  private LocadoraSchema rentalCompany;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "client_id")
  private ClienteSchema client;

//  public LocacaoSchema(DadosCadastroLocacao locacao, Locadora locadora, Cliente cliente) {
//    this.hour = LocalTime.parse(locacao.hour(), DateTimeFormatter.ofPattern("HH:00"));
//    this.date = LocalDate.parse(locacao.date(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//    this.rentalCompany = locadora;
//    this.client = cliente;
//  }

  public LocacaoSchema() {
  }


  public LocalTime getHour() {
    return hour;
  }

  public void setHour(LocalTime hour) {
    this.hour = hour;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocadoraSchema getRentalCompany() {
    return rentalCompany;
  }

  public void setRentalCompany(LocadoraSchema rentalCompany) {
    this.rentalCompany = rentalCompany;
  }

  public ClienteSchema getClient() {
    return client;
  }

  public void setClient(ClienteSchema client) {
    this.client = client;
  }

  public Locacao toLocacao() {
    return new Locacao(
            this.hour,
            this.date,
            this.rentalCompany.toLocadora(),
            this.client.toCliente()
    );
  }
}