import { EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Component, VERSION } from "@angular/core";
import { FormGroup, FormControl, FormBuilder, Validators} from "@angular/forms";
import { Customform } from "../shared/customform";

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.scss']
})
export class FirstComponent implements OnInit {
  ngOnInit(): void {
  }
  myForm: FormGroup;
  customform: Customform[];
  res="";
  constructor(private fb: FormBuilder) {
    this.myForm = this.fb.group({
      FirstName: ['', [Validators.required]],
      LastName: ['', [Validators.required]],
      ContactNumber: ['', [Validators.required, Validators.maxLength(10)]],
      DateOfBirth: ['', [Validators.required]],
      City: ['', [Validators.required]],
      PinCode: ['', [Validators.minLength(6)]]
    });
    this.customform = [];
  }
  onSubmit() {this.res="Its Valid!! Please Click Add Details!"
    // let t=this.myForm.value.DateOfBirth;
    // let p=new Date(parseInt(t[6]+t[7]+t[8]),parseInt(t[0]+t[1]),parseInt(t[3]+t[4]));
  }
  OnAdd()
  {
    let result = this.myForm.value;
    const record : Customform = {
      FirstName : result.FirstName,
      LastName : result.LastName,
      ContactNumber : result.ContactNumber,
      DateOfBirth : result.DateOfBirth,
      City : result.City,
      PinCode : result.PinCode
    };
    this.customform.push(record);
    sessionStorage.setItem('Users',JSON.stringify(this.customform));

    let n=this.customform.length;
    sessionStorage.setItem('obj'+n,JSON.stringify(this.myForm.value));

    this.res="Details added Succesfully!";
    this.myForm.reset();
  }

  OnDisplay()
  {
    let n=this.customform.length;
    for(var i=1;i<=n;i=i+1)
    {
      //console.log( JSON.parse(sessionStorage.getItem('obj'+i) || '{}'));
      //var t= JSON.parse(sessionStorage.getItem('obj'+i) || '{}');
      //this.res="FirstName:"+t.FirstName+"LastName:"+t.LastName+"\nContactNumber:"+t.ContactNumber+"\nDateOfBirth:"+t.DateOfBirth+"\nCity"+t.City+"\nPinCode"+t.PinCode;
      this.res=sessionStorage.getItem('obj'+i) || '{}';
    }
  }

  OnDelete(){
    let n=this.customform.length;
    sessionStorage.setItem('del',JSON.stringify(this.myForm.value));
    for(var i=0;i<=n;i=i+1){
      if((JSON.stringify(sessionStorage.getItem('obj'+i) || '{}'))===JSON.stringify(sessionStorage.getItem('del') || '{}'))
      {
        this.res="Found & Deleted Successfully!!";
        sessionStorage.removeItem('obj'+i);
      }
      else
      {
        this.res="Record Does not Exist!";
      }
    }
  }
  public flag = 1;
  public arrow = "";

  public sorttable(column:string)
  {
    if (this.flag == 1)
    {  this.customform = this.customform.sort((x:any, y: any) => {
        if (x[column] < y[column]) {
          return -1;
        }
        if (x[column] > y[column]) {
          return 1;
        }
        return 0;
      });
      this.flag = 0;
      this.arrow = "↑";
    }
    else {
      this.customform = this.customform.sort((x:any, y: any) => {
        if (x[column] > y[column]) {
          return -1;
        }
        if (x[column] < y[column]) {
          return 1;
        }
        return 0;
      });
      this.flag = 1;
      this.arrow = "↓";
    }
    sessionStorage.setItem('Users', JSON.stringify(this.customform));
  }
  delete(firstname:string) {
    this.customform = this.customform.filter(item => item.FirstName != firstname);
    sessionStorage.setItem('Users', JSON.stringify(this.customform));
    this.res="row deleted";
}

}




