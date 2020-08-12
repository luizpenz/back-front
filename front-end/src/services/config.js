import axios from 'axios'

export const http = axios.create({
    baseURL: 'http://localhost:8080/backend-api/v1/',	
    headers: { 'Authorization': 'Basic cm9vdDpyb290' }
});
