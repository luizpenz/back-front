import { http } from './config'

export default {
    listAll:() => {
        return http.get('pessoa')
    },

    save:(pessoa) => {
        return http.post('pessoa', pessoa)
    },

    update:(pessoa) => {
        return http.put('pessoa', pessoa)
    },

    remove:(id) => {
        return http.delete('pessoa/'+id)
    }

}