const int red = 13;
const int yellow = 12;
const int green = 11;

void setup() {
  pinMode(red, OUTPUT);
  pinMode(yellow, OUTPUT);
  pinMode(green, OUTPUT);

}

void loop() {
  digitalWrite(red, HIGH);
  delay(1000);
  digitalWrite(red, LOW);
  digitalWrite(yellow, HIGH);
  delay(1000);
  digitalWrite(yellow, LOW);
  digitalWrite(green, HIGH);
  delay(1000);
  digitalWrite(green, LOW);
}
