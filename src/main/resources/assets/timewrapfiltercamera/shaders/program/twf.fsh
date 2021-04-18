#version 130

uniform mat4 invViewMat;
uniform mat4 invProjMat;
uniform float progress;
uniform sampler2D depthTex;

in vec2 texCoord;

void main() {

    if (texCoord.y>=progress){
        gl_FragColor = vec4(0.5, 0.5, 0, 1);
    }
}