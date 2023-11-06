package br.ufscar.dc.dsw.bikerental.usecase.costumer.dto;

// Interface do DTO (Data Transfer Object) para ocorrer
// a inversão de dependencias da lib spring boot
// respeitando o desacoplamento da camada de use cases.
public interface IDadosCadastroCliente {

    String username();

    String password();

    String name();

    String email();

    String cpf();

    String phoneNumber();

    String sex();

    String birthdate();
}