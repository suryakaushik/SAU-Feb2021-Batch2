import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { FormsModule } from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from "./app.component";
import { FirstComponent } from './first/first.component';

import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
// import { MatToolbarModule } from "@angular/material/toolbar";
// import { MatListModule } from "@angular/material/list";

// import { MatGridListModule } from "@angular/material/grid-list";
// import { MatCardModule } from "@angular/material/card";
// import { MatButtonModule } from "@angular/material/button";

// import { MatDialogModule } from "@angular/material/dialog";

// import { MatFormFieldModule } from "@angular/material/form-field";
// import { MatInputModule } from "@angular/material/input";
// import { MatCheckboxModule } from "@angular/material/checkbox";

// import { MatSelectModule } from "@angular/material/select";
// import { MatSlideToggleModule } from "@angular/material/slide-toggle";
import { ReactiveFormsModule } from "@angular/forms";

import { MyDatePipe } from "./pipes/mydate.pipe";

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    MyDatePipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    BrowserAnimationsModule,
    // MatToolbarModule,
    // MatGridListModule,
    // MatCardModule,
    // MatButtonModule,
    // MatListModule,
    // MatDialogModule,
    // MatFormFieldModule,
    // MatInputModule,
    // MatCheckboxModule,
    // MatSelectModule,
    // MatSlideToggleModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
