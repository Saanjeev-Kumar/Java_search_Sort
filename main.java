package review;
import java.util.Scanner;
public class Arrays{
private Arrays array[];
private int size;
private int count;
private int id;
private String name;
public Arrays() {
super();
array=new Arrays[1];
size=1;
count=0;
}
public Arrays(int id, String name) {
super();
this.id = id;
this.name = name;
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
static Scanner in=new Scanner(System.in);
public static void main(String[] args) {
Arrays object=new Arrays();
do
{
System.out.println("Press 1 to add elements \n Press 2 to sort elements \n press 3 to search the element \n press 4 to merge two arrays");
int choice=in.nextInt();
switch(choice)
{
case 1:
System.out.println("Enter the details here");
object.addElements();
object.display();
break;
case 2:
System.out.println("sorting \n press 1 to bubble sort \n press 2 to insertion sort");
int sorting=in.nextInt();
switch(sorting) {
case 1:
System.out.println("bubble sort");
object.bubbleSort();
object.display();
break;
case 2:
System.out.println("Insertion sort");
object.insertionSort();
object.display();
break;
default:
System.out.println("invalid choices please select 1 or 2");
break;
}
case 3:
System.out.println("searching \n Press 1 to linear search \n Press 2 to binary search");
int search=in.nextInt();
switch(search)
{
case 1:
System.out.println("Linear search");
object.linearSearch();
break;
case 2:
System.out.println("binary Search");
object.binarySearch();
break;
default:
System.out.println("invalid choice press 1 or 2");
break;
}
case 4:
System.out.println("Enter the arrays thats need to merged \n Enter the second array size");
int n=in.nextInt();
int newArray[]=new int[n];
System.out.println("Enter the array elements that needs to be merged");
for(int i=0;i<n;i++)
{
newArray[i]=in.nextInt();
}
object.merge(newArray);
}
System.out.println("Press 0 to exit");
}while(in.nextInt()!=0);
System.out.println(object.size+"size;------------------------count"+object.count);
object.reduceSize();
System.out.println(object.size+"size;------------------------count"+object.count);
}
private void merge(int[] newArray) {
// TODO Auto-generated method stub
int temp[]=new int[newArray.length+count];
for(int i=0;i<count;i++) {
temp[i]=array[i].getId();
}
for(int i=count,j=0;j<newArray.length;j++)
{
temp[i++]=newArray[j];
}
for (int i = 0; i < temp.length; i++) {
System.out.print("The new merged array "+temp[i]+" ");
}
}
private void binarySearch() {
// TODO Auto-generated method stub
System.out.println("enter the elements needs to be searched");
int search=in.nextInt();
int left=0;
int right=array.length-1;
while(left<=right) {
int mid=left+(right-left)/2;
if(array[mid].getId()==search) {
System.out.println(array[mid].getId()+" "+array[mid].getName()+" are at the postion:"+(mid+1));
break;
}
else if(array[mid].getId()>search) 
right=mid-1;
else if(array[mid].getId()<search) 
left=mid+1;
else
System.out.println("the given element is not found");
}
}
private void linearSearch() {
// TODO Auto-generated method stub
System.out.println("enter the elements needs to be searched");
int search=in.nextInt();
int tempCount=0;
for(int i=0;i<count;i++)
{
if(array[i].getId()==search)
{
System.out.println(array[i].getId()+" "+array[i].getName()+" are at the index of:"+tempCount);
break;
}
tempCount++;
}
}
private void insertionSort() {
// TODO Auto-generated method stub
for(int i=1;i<count;i++)
{
int key=array[i].getId();
int j=i-1;
while(j>=0 && array[j].getId()>key)
{
array[j+1]=array[j];
j--;
}
array[j+1].setId(key);
}
}
private void bubbleSort() {
// TODO Auto-generated method stub
for(int i=0;i<count-1;i++)
{
for(int j=i+1;j<count;j++)
{
if(array[i].getId() > array[j].getId())
{
Arrays temp=array[i];
array[i]=array[j];
array[j]=temp;
}
}
}
}
private void reduceSize() {
// TODO Auto-generated method stub
Arrays temp[]=null;
if(count>0)
{
temp=new Arrays[count];
for(int i=0;i<count;i++) {
temp[i]=array[i];
}
}
size=count;
array=temp;
}
private void display() {
// TODO Auto-generated method stub
for(int i=0;i<count;i++)
{
System.out.println(array[i].getId()+"      "+array[i].getName());
}
}
private void addElements() {
// TODO Auto-generated method stub
if(count ==size)
{
increaseArraySize();
}
System.out.println("enter the id");
int id=in.nextInt();
System.out.println("enter the name");
in.nextLine();
String name=in.nextLine();
array[count++]=new Arrays(id,name);
}
private void increaseArraySize() {
// TODO Auto-generated method stub
Arrays temp[]=null;
if(count==size)
{
temp=new Arrays[size*2];
for(int i=0;i<size;i++)
{
temp[i]=array[i];
}
}
array=temp;
size=size*2;
}

}
