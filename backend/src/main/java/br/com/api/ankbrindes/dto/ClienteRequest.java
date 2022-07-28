package br.com.api.ankbrindes.dto;


import javax.validation.constraints.NotBlank;


public class ClienteRequest  {

	@NotBlank(message = "Preencha o nome")
    private String nome;    
    
    private String endereco;
    
    private String cpfOuCnpj;    

	@NotBlank(message = "Preencha o telefone")
    private String telefone;

    public ClienteRequest() {
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



}
