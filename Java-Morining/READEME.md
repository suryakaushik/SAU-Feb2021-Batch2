JAVA FUNDAMENTALS ASSIGNMENT
1. Read an XML file “”student.xml” containing list of student data in the following format,
deserialize them into java objects, then serialize the unique <rollnumber, total
marks(Phy+chem+math)> to a text file “student.txt” with appropriate exception handling.
<students>
<student>
<roll>12</roll>
<marks>85</marks>
<subject>Maths</subject>
</student>
<student>
<roll>13</roll>
<marks>60</marks>
<subject>physics</subject>
</student>
<student>
<roll>15</roll>
<marks>79</marks>
<subject>chemistry</subject>
</student>
<student>
<roll>13</roll>
<marks>85</marks>
<subject>Maths</subject>
</student>
<student>
<roll>15</roll>
<marks>60</marks>
<subject>physics</subject>
</student>
<student>
<roll>12</roll>
<marks>79</marks>
<subject>chemistry</subject>
</student>
<student>
<roll>13</roll>
<marks>85</marks>
<subject>chemistry</subject>
</student>
<student>
<roll>15</roll>
<marks>60</marks>
<subject>maths</subject>
</student>
<student>
<roll>12</roll>
<marks>79</marks>
<subject>physics</subject>
</student>
</students>
2. Secondly, deserialize the previously stored student.txt file with roll num and total marks.
Then, serialize the top 5 students' roll numbers and total marks into excel or csv file in
the following format.
Rank Roll Number Total Marks(out of 300)
1 12 290
2 45 286
3 60 278
…………………………………..
………………………………….. So on
3. Write the implementation for singleton class.
