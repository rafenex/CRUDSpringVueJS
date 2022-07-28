<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Clientes Front</a>
      </div>
    </nav>

    <div class="container">
      <ul>
        <li v-if="erro">
          <b>{{ erro }}</b>
        </li>

      </ul>

      <form @submit.prevent="salvar">
        <label>Nome</label>
        <input type="text" placeholder="Nome" v-model="cliente.nome">
        <label>Endereço</label>
        <input type="text" placeholder="Endereço" v-model="cliente.endereco">
        <label>Telefone</label>
        <input type="text" placeholder="Telefone" v-model="cliente.telefone">

        <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

      </form>
      <table>
        <thead>
          <tr>
            <th>NOME</th>
            <th>ENDERECO</th>
            <th>TELEFONE</th>
            <th>OPÇÕES</th>
          </tr>
        </thead>
        <tbody>

          <tr v-for="cliente of clientes" :key="cliente.id">
            <td>{{ cliente.nome }}</td>
            <td>{{ cliente.endereco }}</td>
            <td>{{ cliente.telefone }}</td>
            <td>
              <button @click="editar(cliente)" class="waves-effect btn-small blue darken-1"><i
                  class="material-icons">create</i></button>
              <button @click="remover(cliente)" class="waves-effect btn-small red darken-1"><i
                  class="material-icons">delete_sweep</i></button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>

import Cliente from './services/clientes'

export default {
  data() {
    return {
      cliente: {
        id: '',
        nome: '',
        endereco: '',
        telefone: ''
      },

      clientes: [],
      erro: ''
    }
  },
  mounted() {
    this.listar()
  },

  methods: {

    listar() {
      Cliente.listar().then(resposta => {
        this.clientes = resposta.data
      })
    },


    salvar() {
      if (!this.cliente.id) {
        Cliente.salvar(this.cliente).then(() => {
          this.cliente = {}
          alert('Cliente cadastrado')
          this.listar()
          this.erro = ''
        }).catch(e => {
          this.erro = e.response.data
        })
      }
      else {
        Cliente.atualizar(this.cliente).then(() => {
          this.cliente = {}
          alert('Cliente atualizado')
          this.listar()
          this.erro = ''
        }).catch(e => {
          this.erro = e.response.data
        })
      }
    },

    editar(cliente) {
      this.cliente = cliente;
    },

    remover(cliente) {
      if (confirm('Deseja excluir o produto?')) {
        Cliente.apagar(cliente).then(() => {
          this.erro = '';
          this.listar();
        }).catch(e => {
          this.erro = e.response.data
        })
      }
    }

  }
}
</script>

<style>
</style>