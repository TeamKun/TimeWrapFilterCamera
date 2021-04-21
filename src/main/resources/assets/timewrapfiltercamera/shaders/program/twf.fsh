#version 130

uniform mat4 invViewMat;
uniform mat4 invProjMat;
uniform float progress;
uniform sampler2D depthTex;
uniform sampler2D DiffuseSampler;
uniform sampler2D PrevSampler;

varying vec2 texCoord;


void main() {

    if (texCoord.y>=progress){
        vec4 PrevTexel = texture2D(PrevSampler, texCoord);
        vec4 CurrTexel = texture2D(DiffuseSampler, texCoord);

        gl_FragColor=CurrTexel;
    } else {
        gl_FragColor=vec4(0, 0, 0, 1);
    }
}