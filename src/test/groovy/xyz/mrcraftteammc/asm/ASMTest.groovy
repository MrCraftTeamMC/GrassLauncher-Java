package xyz.mrcraftteammc.asm

import org.junit.jupiter.api.Test
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.MethodVisitor
import xyz.mrcraftteammc.grasslauncher.common.annotation.TestOnly

import static org.objectweb.asm.Opcodes.ASM9

class ASMTest {
    @Test
    void classVisit() {
        MyClassVisitor visitor = new MyClassVisitor()
        ClassReader reader = new ClassReader(ASMTest.TestClass.class.getName())
        reader.accept(visitor, 0)
    }

    @TestOnly
    class TestClass {
        int x = 114
        int y = 514

        void add() {
            println x+y
        }
    }

    class MyClassVisitor extends ClassVisitor {
        MyClassVisitor() {
            super(ASM9)
        }

        @Override
        void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
            System.out.println(name + " extends " + superName + " {")
            super.visit(version, access, name, signature, superName, interfaces)
        }

        @Override
        FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
            System.out.println(desc + " " + name)
            return super.visitField(access, name, desc, signature, value)
        }

        @Override
        MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            System.out.println(name + " " + desc)
            return super.visitMethod(access, name, desc, signature, exceptions)
        }

        @Override
        void visitEnd() {
            System.out.println("}")
            super.visitEnd()
        }
    }
}
