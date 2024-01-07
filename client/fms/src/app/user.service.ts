import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  getUserById(userId: number) :Observable<User>
  {
    return this.httpClient.get<User>(`${this.baseUrl}/${userId}`);
   
  }

 
  

  

  updateUser(userId: number, user: User): Observable<any> {
    return this.httpClient.put(`${this.baseUrl}/${userId}`, user);
  }
  
  createUser(user: User):Observable<Object>
  {
   return this.httpClient.post(`${this.baseUrl2}`,user);
  }


  deleteUser(id: number):Observable<any>
  {
   return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }

  
 

  private baseUrl="http://localhost:8082/user";
  private baseUrl2="http://localhost:8082/user/addnewuser";

  constructor(private httpClient:HttpClient) { }
  getUsersList():Observable<User[]>
  {
    return this.httpClient.get<User[]>(`${this.baseUrl}`);
  }
}
