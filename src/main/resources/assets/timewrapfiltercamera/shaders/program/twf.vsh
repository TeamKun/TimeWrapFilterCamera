#version 130

varying vec2 texCoord;

void main() {
    texCoord = gl_MultiTexCoord0.st;
    gl_Position = ftransform();
}