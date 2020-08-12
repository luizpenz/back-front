<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Aplicação Front-end</a>
      </div>
    </nav>

    <div class="container">
      <ul>
        <li v-for="(erro, index) of errors" :key="index">
          campo <b>{{erro.field}}</b> - {{erro.message}}
        </li>
      </ul>

      <form @submit.prevent="save">
        <tr>
          <td>
            <label>Nome</label>
            <input type="text" placeholder="Nome" v-model="pessoa.nome" >
          </td>
          <td>
            <label>Cpf</label>
            <input type="number" placeholder="cpf (somente números)" v-model="pessoa.cpf" >
          </td>
          <td>
            <label>Data Nascimento</label>
            <input type="date" placeholder="Data Nascimento" v-model="pessoa.dataNascimento" >
          </td>
        </tr>
        <tr>
          <td>
            <label>Sexo</label>
            <input type="text" placeholder="MASCULINO/FEMININO"  v-model="pessoa.sexo" >
          </td>
          <td>
            <label>Naturalidade</label>
            <input type="text" placeholder="Naturalidade" v-model="pessoa.naturalidade" >
          </td>
          <td>
            <label>Nacionalidade</label>
            <input type="text" placeholder="Nacionalidadae" v-model="pessoa.nacionalidade" >
          </td>
        </tr>
        <input type="email" placeholder="e-mail" v-model="pessoa.email" >       
        <tr>
          <td> <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button> </td>
          <td> <button @click="listAll()" class="waves-effect waves-light btn-small red">Cancelar<i class="material-icons left">cancel</i></button> </td>
        </tr>
      </form>

      <table>

        <thead>

          <tr>
            <th>NOME</th>
            <th>CPF</th>
            <th>E-MAIL</th>
            <th>OPÇÕES</th>
          </tr>

        </thead>

        <tbody>

          <tr v-for="pessoa of pessoas" :key="pessoa.id">

            <td>{{ pessoa.nome }}</td>
            <td>{{ pessoa.cpf }}</td>
            <td>{{ pessoa.email }}</td>
            <td>
              <button @click="update(pessoa)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="remove(pessoa)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>
          </tr>
        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>

import Pessoa from './services/pessoas'

export default {
  name: 'app',
  data () {
    return {
      pessoa: {
        id: '',
        dataCadastro: '',
        dataAlteracao: '',
        nome: '',
        sexo: '',
        email: '',
        dataNascimento: '',
        naturalidade: '',
        nacionalidade: '',
        cpf: ''
      },
      pessoas: {},
      errors: {},
      picked: ''
    }
  },

  mounted(){
    this.listAll()
  },

  methods: {
    
    listAll(){
      Pessoa.listAll().then(response => {
        this.pessoas = response.data.content,
        this.pessoa = {},
        this.errors = {}
      })
    },

    save() {
      if(!this.pessoa.id){
        Pessoa.save(this.pessoa).then(() => {
          this.listAll()
        }).catch(e => {
          this.errors = e.response.data.details
        })
      }else{
        Pessoa.update(this.pessoa).then(() => {
          this.listAll()
        }).catch(e => {
          this.errors = e.response.data.details
        })
      }
    },

    update(pessoa){
      this.pessoa = pessoa
    },

    remove(pessoa) {
      if(confirm('Deseja excluir o registro?')){
        Pessoa.remove(pessoa.id).then(() => {
          this.listAll()
        }).catch(e => {
          console.log(e.response)
        })
      }
    }

  }
}

</script>
