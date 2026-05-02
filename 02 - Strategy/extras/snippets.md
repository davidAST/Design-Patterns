# Geometry Helper Snippets

## Rectangle

```java
// int x, y; coordinates of the point where the mouse was pressed
// Point corner; int width, height; attributes of the rectangle

boolean clicked = (corner.x <= x && x <= corner.x + width)
               && (corner.y <= y && y <= corner.y + height);
```

## Circle

```java
// int x, y; coordinates of the point where the mouse was pressed
// Point center; int radius; attributes of the circle

double distance = Math.sqrt(Math.pow(x - center.x, 2) + Math.pow(y - center.y, 2));
boolean clicked = distance < radius;
```

## Triangle

```java
// int x, y; coordinates of the point where the mouse was pressed
// Point v1, v2, v3; the three vertices of the triangle

Point position = new Point(x, y);
boolean clicked = position.equals(v1) || position.equals(v2) || position.equals(v3);
```
