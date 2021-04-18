package net.kunmc.lab.twfc.client.shader;

import net.kunmc.lab.twfc.TimeWrapFilterCamera;
import net.kunmc.lab.twfc.client.util.ClientUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.ShaderDefault;
import net.minecraft.client.shader.ShaderInstance;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraftforge.resource.ISelectiveResourceReloadListener;
import net.minecraftforge.resource.VanillaResourceType;

import java.io.IOException;

public class TWFShader {
    private static final TWFShader INSTANCE = new TWFShader();
    private static final Minecraft mc = Minecraft.getInstance();
    protected ShaderInstance shaderInstance;
    private ShaderDefault inverseViewMatrixUniform;
    private ShaderDefault inverseProjectionMatrixUniform;
    private ShaderDefault progressitionUniform;

    public static TWFShader getInstance() {
        return INSTANCE;
    }

    public void init() {
        IResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
        ClientUtils.deferTask(() -> reloadShaders(resourceManager));
        if (resourceManager instanceof IReloadableResourceManager) {
            ((IReloadableResourceManager) resourceManager).registerReloadListener((ISelectiveResourceReloadListener) (manager, predicate) -> {
                if (predicate.test(VanillaResourceType.SHADERS)) {
                    reloadShaders(manager);
                }
            });
        }
    }

    private void reloadShaders(final IResourceManager manager) {
        if (shaderInstance != null) {
            shaderInstance.close();
            shaderInstance = null;
        }
        try {
            shaderInstance = new ShaderInstance(manager, TimeWrapFilterCamera.MODID + ":twf");
            handleShaderLoad();
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
    }

    public void handleShaderLoad() {
        inverseViewMatrixUniform = shaderInstance.safeGetUniform("invViewMat");
        inverseProjectionMatrixUniform = shaderInstance.safeGetUniform("invProjMat");
        progressitionUniform = shaderInstance.safeGetUniform("progress");
    }

    public void setInverseViewMatrix(Matrix4f value) {
        inverseViewMatrixUniform.set(value);
    }

    public void setInverseProjectionMatrix(Matrix4f value) {
        inverseProjectionMatrixUniform.set(value);
    }

    public void setProgress(float value) {
        progressitionUniform.set(value);
    }

    public void setDepthBuffer(int buffer) {
        shaderInstance.setSampler("depthTex", () -> buffer);
    }

    public void bind() {
        if (shaderInstance != null) {
            shaderInstance.apply();
        }
    }

    public void unbind() {
        if (shaderInstance != null) {
            shaderInstance.clear();
        }
    }

}
