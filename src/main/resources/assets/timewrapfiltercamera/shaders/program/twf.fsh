#version 130

uniform mat4 invViewMat;
uniform mat4 invProjMat;
uniform float progress;
uniform sampler2D depthTex;
uniform sampler2D DiffuseSampler;
uniform sampler2D PrevSampler;

varying vec2 texCoord;


void main() {
    vec4 CurrTexel = texture2D(DiffuseSampler, texCoord);

 //   if (texCoord.y<=progress){

        gl_FragColor=vec4(0, CurrTexel.g, CurrTexel.b, 1);
   // } else {
   //     gl_FragColor=CurrTexel;
 //   }
}