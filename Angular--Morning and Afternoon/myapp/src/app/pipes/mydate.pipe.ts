import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
  name: "MyDate"
})
export class MyDatePipe implements PipeTransform {
  getMonth(month: string) {
    let months = [
      "January",
      "February",
      "March",
      "April",
      "May",
      "June",
      "July",
      "August",
      "September",
      "October",
      "November",
      "December"
    ];
    return months[parseInt(month) - 1];
  }
  transform(value: string, format: string) {
    if (format === "MM DD, YYYY") {
      let arr = value.split("-");
      return this.getMonth(arr[1]) + " " + arr[0] + " , " + arr[2];
    }
    return value;
  }
}
