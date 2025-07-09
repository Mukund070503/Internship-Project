import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RuleService {
  private baseUrl:string="http://localhost:8080/api/v1/limit-config";
  constructor(private http:HttpClient) { }
  private baseUrl2:string="http://localhost:8081/api/v1/mpin/client/config";
  private baseUrl3:string="http://localhost:8082/api/v1";
  private baseUrl4:string="http://localhost:8083/api";
  allRules(){
    return this.http.get(`${this.baseUrl}/get-rules`)
  }
  updateRule(data:any){
    return this.http.post(`${this.baseUrl}/update-rule`,data)
  }
  enterRule(data:any){
    return this.http.post(`${this.baseUrl}/add-rule`,data)
  }
  allTeams(){
    return this.http.get(`${this.baseUrl2}/getData`)
  }
  updateTeam(data:any){
    return this.http.post(`${this.baseUrl2}/updateTeam`,data)
  }
  enterTeam(data:any){
    return this.http.post(`${this.baseUrl2}/addTeam`,data)
  }
  allClientsBySId(sId:String){
    return this.http.get(`${this.baseUrl2}/getDataBySId?sId=${sId}`)
  }
  allClientsById(id: number) {
    return this.http.get(`${this.baseUrl2}/getDataById?id=${id}`);
  }  
  adharApi(data:any){
    return this.http.post(`${this.baseUrl3}/auth/Adhar`,data)
  }
  panApi(data:any){
    return this.http.post(`${this.baseUrl3}/auth/pan`,data)
  }
  allClients(){
    return this.http.get(`${this.baseUrl3}/clients`)
  }
  allBanks(){
    return this.http.get(`${this.baseUrl4}/banks`)
  }
  allBranches(){
    return this.http.get(`${this.baseUrl4}/branches`)
  }
  deleteBank(data:any){
    return this.http.post(`${this.baseUrl4}/removeBank`,data)
  }
  deleteBranch(data:any){
    return this.http.post(`${this.baseUrl4}/removeBranch`,data)
  }
  allBanksByBankCode(data:any){
    return this.http.post(`${this.baseUrl4}/banksByBankCode`,data)
  }
  allBranchesByIfsc(data:any){
    return this.http.post(`${this.baseUrl4}/branchesByIfsc`,data)
  }

    insertBank(data:any){
    return this.http.post(`${this.baseUrl4}/insertBank`,data,{ responseType: 'text' })
  }
    insertBranch(data:any){
    return this.http.post(`${this.baseUrl4}/insertBranch`,data,{ responseType: 'text' })
  }
    updateBank(data:any){
    return this.http.post(`${this.baseUrl4}/updateBank`,data,{ responseType: 'text' })
  }
    updateBranch(data:any){
    return this.http.post(`${this.baseUrl4}/updateBranch`,data,{ responseType: 'text' })
  }
}
