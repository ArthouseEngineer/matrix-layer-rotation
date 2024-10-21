import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.rbi.matrixRotation

class MatrixRotationTest : BehaviorSpec({

    Given("Test Case 1: Matrix 4x4 with 2 rotations") {
        val matrix = arrayOf(
            arrayOf(1, 2, 3, 4),
            arrayOf(5, 6, 7, 8),
            arrayOf(9, 10, 11, 12),
            arrayOf(13, 14, 15, 16)
        )
        val expected = arrayOf(
            arrayOf(3, 4, 8, 12),
            arrayOf(2, 11, 10, 16),
            arrayOf(1, 7, 6, 15),
            arrayOf(5, 9, 13, 14)
        )
        val rotations = 2

        When("the matrix is rotated 2 times") {
            matrixRotation(matrix, rotations)

            Then("the matrix should match the expected output") {
                matrix shouldBe expected
            }
        }
    }

    Given("Test Case 2: Matrix 5x4 with 7 rotations") {

        val matrix = arrayOf(
            arrayOf(1, 2, 3, 4),
            arrayOf(7, 8, 9, 10),
            arrayOf(13, 14, 15, 16),
            arrayOf(19, 20, 21, 22),
            arrayOf(25, 26, 27, 28)
        )
        val expected = arrayOf(
            arrayOf(28, 27, 26, 25),
            arrayOf(22, 9, 15, 19),
            arrayOf(16, 8, 21, 13),
            arrayOf(10, 14, 20, 7),
            arrayOf(4, 3, 2, 1)
        )
        val rotations = 7

        When("the matrix is rotated 7 times") {
            matrixRotation(matrix, rotations)

            Then("the matrix should match the expected output") {
                matrix shouldBe expected
            }
        }
    }



    Given("Test Case 3: Matrix 2x2 with 3 rotations") {
        val matrix = arrayOf(
            arrayOf(1, 1),
            arrayOf(1, 1)
        )
        val expected = arrayOf(
            arrayOf(1, 1),
            arrayOf(1, 1)
        )
        val rotations = 3

        When("the matrix is rotated 3 times") {
            matrixRotation(matrix, rotations)

            Then("the matrix should match the expected output") {
                matrix shouldBe expected
            }
        }
    }
})