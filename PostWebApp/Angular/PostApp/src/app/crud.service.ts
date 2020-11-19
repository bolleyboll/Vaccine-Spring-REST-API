import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  posts : any[]
  constructor(public http : HttpClient) {
   }
  getPosts(){
    this.http.get("https://jsonplaceholder.typicode.com/users/1/posts").subscribe((data : any[]) => this.posts=data)
  }
}
